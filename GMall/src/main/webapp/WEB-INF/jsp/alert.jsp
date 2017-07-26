<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<script>
	swal({title: "다시 시도해주세요.", text: "${msg}", type: "error"}, function(){ location.href="${url}"; });
</script>