set serverout on
exec dbms_output.enable(10000);

declare 
i number; 
begin 
for i in 1..10000 loop 
if round(dbms_random.value)=0 then 
  dbms_output.put('/'); 
else 
  dbms_output.put('\'); 
end if; 
end loop; 
dbms_output.new_line; 
end;
/
