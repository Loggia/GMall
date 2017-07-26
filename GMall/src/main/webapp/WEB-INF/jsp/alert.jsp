<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<script>
	swal({title: "Error", text: "${msg}", type: "error"}, function() { location.href="${url}"; });
</script>