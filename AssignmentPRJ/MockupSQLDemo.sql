select * from [Session] s inner join [Group] g
on s.GroupID = g.GroupID
where g.LecturerID like 'sonnt5'
and s.SessionDate between '2022-05-11' and '2022-05-19'

select * from TimeSlot

select * from [Attendance] a
inner join [Student] s on a.StudentID = s.StudentID
inner join [Session] ss on a.SessionID = ss.SessionID
inner join [Group] g on ss.GroupID = g.GroupID
where ss.Semester like 'SUM22' and g.LecturerID like 'sonnt5' and g.GroupID = 1 and ss.SessionDate = '2022-05-11' and ss.SlotID = 5