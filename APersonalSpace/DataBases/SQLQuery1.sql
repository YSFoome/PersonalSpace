create table usersendmsg
(
	id varchar(50) constraint usd_id_for_ui foreign key references userinfo(id),
	time varchar(50),
	sendcontent text
)


select * from usersendmsg order by time desc
delete usersendmsg where id=1 and time='2022-6-24 16:1'
delete usersendmsg 

insert userinfo(id,name,passwd)
values(?,?,?)