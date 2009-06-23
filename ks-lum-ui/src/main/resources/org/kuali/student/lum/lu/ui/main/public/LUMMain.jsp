<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	import="org.kuali.student.common.ui.server.messages.MessageRPCPreloader"%>
<%@page	import="org.kuali.student.common.ui.server.dictionary.DictionaryRPCPreloader"%>
<%@page import="org.kuali.student.lum.lu.ui.course.client.configuration.LUConstants"%>
	
<html>
<head>
<title>LUM Application</title>

</head>

<body>

<%
    try {
        MessageRPCPreloader messageRPCPreloader = new MessageRPCPreloader();
        String messageData = messageRPCPreloader.getMessagesByGroupsEncodingString("en", new String[]{"common"});
        
        //TODO need to load all dictionary structures
        DictionaryRPCPreloader preloader = new DictionaryRPCPreloader("luClient");
        String dictionaryData = preloader.getObjectStructuresEncodedString(LUConstants.STRUCTURE_CLU_INFO);

%>
<script type="text/javascript"> var i18nMessages = '<%=messageData%>';</script>
<script type="text/javascript"> var dictionaryData = '<%=dictionaryData%>';</script>
<%
    } catch (Exception e) {

        e.printStackTrace();
    }
%>

<!-- OPTIONAL: include this if you want history support -->
<iframe src="javascript:''" id="__gwt_historyFrame"
	style="width: 0; height: 0; border: 0"> </iframe>

<script type="text/javascript" language="javascript"
	src="org.kuali.student.lum.lu.ui.main.LUMMain.nocache.js">
		</script>
</body>
</html>