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
