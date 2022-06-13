# bitcamp-study
<!-- 게시글 셀렉트  -->
select
		b.b_no,
		b.content,
		b.reg_dt,
		m.memb_no writer_no,
		m.name writer_name,
		c.cmt_no,
		c.content cmt_content,
		c.reg_dt cmt_reg_dt,
		m2.memb_no cmt_writer_no,
		m2.name cmt_writer_name
	from
	   gms_board b
		left outer join gms_comment c on b.b_no = c.b_no
		left outer join gms_memb m on b.memb_no = m.memb_no
		left outer join gms_memb m2 on c.memb_no = m2.memb_no
    order by
      b_no desc

<!-- 게시글 인서트 -->
insert into gms_board(g_no, memb_no, content)
values(#{groupNo}, #{memberNo}, #{content})

<!-- 게시글 업데이트 -->
update gms_board set
      g_no = 1,
      memb_no = 1,
      content = '오늘 은 우중충충해'
    where
      b_no = #{no}

<!-- 모임목적 인서트문 -->
insert into gms_purpose(name) values ("교육/자기개발");
insert into gms_purpose(name) values ("육아/가족/반려동물");
insert into gms_purpose(name) values ("인문/과학");
insert into gms_purpose(name) values ("스포츠/레져");
insert into gms_purpose(name) values ("도서/독서");
insert into gms_purpose(name) values ("정치/사회/역사");
insert into gms_purpose(name) values ("건강/의료");
insert into gms_purpose(name) values ("영화/애니메이션");
insert into gms_purpose(name) values ("경제/금융/재테크");
insert into gms_purpose(name) values ("인테리어/조경/DIY");
insert into gms_purpose(name) values ("게임");
insert into gms_purpose(name) values ("여행/취미/여가");
insert into gms_purpose(name) values ("공연/전시");
insert into gms_purpose(name) values ("디자인");
insert into gms_purpose(name) values ("TV/미디어");
insert into gms_purpose(name) values ("패션/뷰티");
insert into gms_purpose(name) values ("외국어");
insert into gms_purpose(name) values ("IT/컴퓨터");
insert into gms_purpose(name) values ("쇼핑/생활/푸드");
insert into gms_purpose(name) values ("기부/봉사");
insert into gms_purpose(name) values ("창업/경영");
insert into gms_purpose(name) values ("문화/예술/음악");


<!-- 시 목록 셀렉트 -->
select distinct name_si from gms_activelocal;
<!-- 시에 해당하는 군구 셀렉트 -->
SELECT name_gu FROM gms_activelocal WHERE name_si LIKE '%서울%';


<!-- 신청서 가져 오기  -->
select
      f.appl_no,
			f.g_no,
			f.memb_no,
			f.content,
			quest.question_name
    from
      gms_applyform f
			right outer join
			(
			select q.* from gms_applyform_question q where q.appl_no = (select f.appl_no from gms_applyform f where f.g_no = 2)
			)
			as quest on f.appl_no = quest.appl_no;

			select
			      f.*,
						quest.question_name
			    from
			      gms_applyform f
						right outer join
						(
						select q.* from gms_applyform_question q where q.appl_no = (select f.appl_no from gms_applyform f where f.g_no = 2)
						)
						as quest on f.appl_no = quest.appl_no;



군구 선택까지
select
            g.g_no,
            g.act_local_no,
            g.pups_no,
            g.name,
            g.reg_dt,
            g.logo,
            g.intro,
            g.max_cnt,
            g.view_cnt,
            p.pups_no pno,
            p.name pname,
            a.act_local_no ano,
            a.name_si asi,
            a.name_gu agu
        from gms_group g
            inner join gms_purpose p on g.pups_no=p.pups_no
            inner join gms_activelocal a on g.act_local_no=a.act_local_no
        where
           a.act_local_no =



select
           g.g_no,
           g.act_local_no,
           g.pups_no,
           g.name,
           g.reg_dt,
           g.logo,
           g.intro,
           g.max_cnt,
           g.view_cnt,
           p.pups_no pno,
           p.name pname,
           a.act_local_no ano,
           a.name_si asi,
           a.name_gu agu
       from gms_group g
           inner join gms_purpose p on g.pups_no=p.pups_no
           inner join gms_activelocal a on g.act_local_no=a.act_local_no
       where
          a.act_local_no = 1
       order by
           g.g_no desc;




 select * from 
 (select
            g.g_no,
            g.act_local_no,
            g.pups_no,
            g.name,
            g.reg_dt,
            g.logo,
            g.intro,
            g.max_cnt,
            g.view_cnt,
            p.pups_no pno,
            p.name pname,
            a.act_local_no ano,
            a.name_si asi,
            a.name_gu agu
        from gms_group g
            inner join gms_purpose p on g.pups_no=p.pups_no
            inner join gms_activelocal a on g.act_local_no=a.act_local_no
        where
           a.act_local_no = 1
        order by
            g.g_no desc) g
						where g.pups_no = 1


git clone  test3
