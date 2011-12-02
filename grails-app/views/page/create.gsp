<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <meta name="layout" content="main"/>
      <title>Create Page</title>
  </head>
  <body>
    <g:form action="save" class="form-stacked" method="POST">
        <g:hiddenField name="title" value="${page.title}"/>
        <div class="clearfix">
            <label for="content">Page Content</label>
            <g:textArea id="content" class="span12" name="content" value="${page.content}" rows="20" cols="100"/>
        </div>
        <div>
            <g:submitButton name="save" class="btn primary"/>
        </div>
    </g:form>
  </body>
</html>