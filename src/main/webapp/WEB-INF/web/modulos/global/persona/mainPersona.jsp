<%-- 
    Document   : mainPersona
    Created on : 29-nov-2018, 21:48:36
    Author     : TOSHIBA
--%>

<script src='/webjars/AdminLTE/2.4.2/bower_components/jquery/dist/jquery.min.js'></script>
<link rel="stylesheet" href="/resources/css/jquery.dataTables.min.css">
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <h1>
      Page Header
      <small>Optional description</small>
    </h1>
    <ol class="breadcrumb">
      <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
      <li class="active">Here</li>
      <li class="active"><a  class="btn btn-warning">Ir Persona</a></li>
    </ol>
  </section>

  <!-- Main content -->
  <section class="content">

    <!-- Your Page Content Here -->

    Idioma: <a href="?lang=en">Ingles</a> | <a href="?lang=fr">Frances</a> | <a href="?lang=es">Espa�ol</a><br/> 
    Mensaje: 
    ${message} <br/>               
    <p> <spring:message code="welcome.greeting" arguments="${startMeeting}" /> </p> 
    <br/>
          <div class="box">
          <div class="box-body">
            <form action="${pageContext.request.contextPath}/buscarPer" method="POST">

            <div class="form-group">
                <label class="col-sm-2 control-label">Nombre:</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control"  id="dato" name="dato"/>                     
                </div>                
                <div class="col-sm-1">
                    <input type="submit" value="Buscar" class="btn btn-primary"/>
                </div>
                <div class="col-sm-1">
                    <a class="btn btn-info" href="${pageContext.request.contextPath}/formPersona">Nuevo</a>  
                </div>
            </div>
              </form>
          </div>
          </div>        
    <c:if test="${!empty ListaPersona}">
        <div class="box">
                <div class="box-header">
                    <h3 class="box-title">Reporte de Personas</h3>                                    
                </div><!-- /.box-header -->        
        <div class="box-body table-responsive">
        <table id="example1" class="table table-bordered table-striped">
          <thead >
            <tr>
              <th >Nombre</th>
              <th >Apellido</th>
              <th >Telefono</th>
              <th >Nombre Familiar</th>
              <th >Numero Familiar</th>
              <th >Email</th>
              <th >Opciones</th>
            </tr>
          </thead>
          <tbody>
                <c:forEach items="${ListaPersona}" var="dato">
                      <tr>
                        <td>${dato.nombre}</td>
                        <td>${dato.apellido}</td>
                        <td>${dato.telefono}</td>
                        <td>${dato.nombreFamiliar}</td>
                        <td>${dato.numeroFamiliar}</td>
                        <td>${dato.email}</td>
                        <td align="center">
                            <a href="${pageContext.request.contextPath}/elimper?id=${dato.idpersona}" ><span title="Eliminar" class="glyphicon glyphicon-remove"></span></a>
                            <a href="${pageContext.request.contextPath}/formModif2Persona?id=${dato.idpersona}" ><span title="Editar" class="glyphicon glyphicon-edit"></span></a>
                        
                        </td>
                      </tr>
              </c:forEach> 
            </tbody>
            <tfoot>
                <tr>
              <th >Nombre</th>
              <th >Apellido</th>
              <th >Telefono</th>
              <th >Nombre Familiar</th>
              <th >Numero Familiar</th>
              <th >Email</th>
              <th >Opciones</th>
                </tr>
            </tfoot>            
          </table>  
          </div>
        </div>                                
          </c:if>                   
  </section><!-- /.content -->  

</div><!-- /.content-wrapper -->
<script>
  $(function () {
    $('#example1').DataTable();
//    $('#example2').DataTable({
//      'paging'      : true,
//      'lengthChange': true,
//      'searching'   : true,
//      'ordering'    : true,
//      'info'        : true,
//      'autoWidth'   : false
//    });
  });
</script>
