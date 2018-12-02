<%-- 
    Document   : formPersona
    Created on : 29-nov-2018, 21:48:21
    Author     : TOSHIBA
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<script src='/webjars/AdminLTE/2.4.2/bower_components/jquery/dist/jquery.min.js'></script>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
<!-- Main content -->
<section class="content">    
    <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Formulario de Registro</h3>
            </div>
    <c:url var="urlsave" value="${pageContext.request.contextPath}/${urlAccion}" />
    <frm:form modelAttribute="modeloPersona" method="post" action="${urlsave}" class="form-horizontal" >
  
            <div class="box-body">
                <div class="form-group">
                    <frm:hidden path="idpersona" />
                    <frm:label path="nombre" class="col-sm-2 control-label" >Nombre:</frm:label>
                    <div class="col-sm-10">
                    <frm:input path="nombre" class="form-control" />
                    </div>
                </div>
                <div class="form-group">                    
                    <frm:label path="apellido" class="col-sm-2 control-label" >Apellido</frm:label>
                    <div class="col-sm-10">
                    <frm:input path="apellido" class="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <frm:label path="dni" class="col-sm-2 control-label">DNI:</frm:label>
                    <div class="col-sm-10"><frm:input path="dni" class="form-control" /></div>
                </div>
                <div class="form-group">
                    <frm:label path="telefono" class="col-sm-2 control-label">Telefono:</frm:label>
                    <div class="col-sm-10"><frm:input path="telefono" class="form-control" /></div>
                </div>
                <div class="form-group ">
                    <frm:label path="fechaNacimiento" class="col-sm-2 control-label">F.Nacimiento:</frm:label>
                    <div class="col-sm-10" >
                    <frm:input path="fechaNacimiento"  class="form-control" id="datepicker" placeholder="yyyy/mm/dd" />
                    </div>
                </div> 
                <div class="form-group" >
                    <frm:label path="nombreFamiliar" class="col-sm-2 control-label">Nombre Familiar:</frm:label>
                    <div class="col-sm-10"><frm:input path="nombreFamiliar" class="form-control" /></div>
                </div>
                <div class="form-group" >
                    <frm:label path="numeroFamiliar" class="col-sm-2 control-label">Numero Familiar:</frm:label>
                    <div class="col-sm-10"><frm:input path="numeroFamiliar" class="form-control" /></div>
                </div>
                <div class="form-group" >
                    <frm:label path="religion" class="col-sm-2 control-label">Religion:</frm:label>
                    <div class="col-sm-10"><frm:input path="religion" class="form-control" /></div>
                </div>
                <div class="form-group" >
                  <frm:label path="email" class="col-sm-2 control-label">Email address</frm:label>
                  <div class="col-sm-10"><frm:input path="email" class="form-control" id="email" placeholder="Enter email" /></div>
                </div>
              </div>
              <!-- /.box-body -->

                        
              <div class="box-footer" style="margin-left: 80px">                
                  <input type="submit" value="Guardar" class="btn btn-primary" />
                  
                  &nbsp;&nbsp;
                  <a href="${pageContext.request.contextPath}/perMain" class="btn btn-primary">Cancelar</a> 
              </div>            
    </frm:form>
</div>

</section> 
<script type="text/javascript">
    $(function () {
       //$('#datetimepicker1').datetimepicker();
    $('#datepicker').datepicker({        
        //format: 'dd-MMM-yyyy'
        format: 'yyyy/mm/dd'
    }); 

        var dato=$('#datepicker').val();
        var dato2=dato.replace('-','/')
        
        $('#datepicker').val(dato2.replace('-','/'));
        //alert(dato2.replace('-','/'));
    });
</script>     
</div> 
