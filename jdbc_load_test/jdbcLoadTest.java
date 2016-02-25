import java.sql.*;

public class jdbcLoadTest {

    public static void JDBCClose(Connection connection, ResultSet resultSet, PreparedStatement preparedStatement){
        if (resultSet != null) {
            try {
                resultSet.close();
                resultSet = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                preparedStatement = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            if (connection!= null && !connection.isClosed()){
                if (!connection.getAutoCommit()) {
                    connection.commit();
                    connection.setAutoCommit(true);
                }
                connection.close();
                connection= null;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public static void main(String[] argv) {
        final long startTime = System.currentTimeMillis();
        final int ONE_HOUR_IN_MS = 1000*60*60;//
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        Timestamp NOSP_SCHEDULE_PERIOD_START = null;
        Timestamp NOSP_SCHEDULE_PERIOD_START_VAR = null;
        NOSP_SCHEDULE_PERIOD_START = Timestamp.valueOf("2013-10-22 04:00:00"); //("yyyy-mm-dd hh:mm:ss")

        System.out.println("NOSC_NAME" + "\t"+ "NOSP_SCHEDULE_PERIOD_START_DISP" + "\t");
        System.out.println("----------------------------------------------------------");

        for (int i=0 ; i<2000 ; i++){
            NOSP_SCHEDULE_PERIOD_START_VAR = new Timestamp(NOSP_SCHEDULE_PERIOD_START.getTime()+(i*ONE_HOUR_IN_MS));

            try {
                //System.out.println("Connecting...");
                connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl", "username", "password");

                String sql = "SELECT * FROM V_NOMINATION_SCHED_QUANTITY WHERE (((NOSQ_STATUS = ?)) AND (CONTRACT_ID = ?) AND (NOSP_SCHEDULE_PERIOD_START = ?))";
                //System.out.println("Running with sql:"+sql);

                stmt = connection.prepareStatement(sql);
                stmt.setString(1,"GENERATED");
                stmt.setString(2,"24DAC782-9B20-B96B-1576-3B204ED6CCF3");
                stmt.setTimestamp(3,NOSP_SCHEDULE_PERIOD_START_VAR);

                //System.out.println("Executing query");
                stmt.executeQuery();
                resultSet=stmt.getResultSet();

                while (resultSet.next()) {
                    String NOSC_NAME = resultSet.getString("NOSC_NAME");
                    Timestamp NOSP_SCHEDULE_PERIOD_START_DISP = resultSet.getTimestamp("NOSP_SCHEDULE_PERIOD_START");
                    System.out.println(NOSC_NAME + "\t"+ NOSP_SCHEDULE_PERIOD_START_DISP + "\t");
                }
            }
            catch (SQLException e) {
                System.out.println("Error occurred");
                e.printStackTrace();
            }
            finally{
                JDBCClose(connection,resultSet,stmt);
            }

        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime)/1000+"s" );

    }
}
