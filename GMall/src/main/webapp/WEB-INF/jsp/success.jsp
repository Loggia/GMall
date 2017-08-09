<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<script>
	swal({title: "Success", text: "${msg}", type: "success"}, function() { location.href="${url}"; });
</script>