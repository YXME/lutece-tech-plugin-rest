![](https://dev.lutece.paris.fr/jenkins/buildStatus/icon?job=tech-plugin-rest-deploy)
[![Alerte](https://dev.lutece.paris.fr/sonar/api/project_badges/measure?project=fr.paris.lutece.plugins%3Aplugin-rest&metric=alert_status)](https://dev.lutece.paris.fr/sonar/dashboard?id=fr.paris.lutece.plugins%3Aplugin-rest)
[![Line of code](https://dev.lutece.paris.fr/sonar/api/project_badges/measure?project=fr.paris.lutece.plugins%3Aplugin-rest&metric=ncloc)](https://dev.lutece.paris.fr/sonar/dashboard?id=fr.paris.lutece.plugins%3Aplugin-rest)
[![Coverage](https://dev.lutece.paris.fr/sonar/api/project_badges/measure?project=fr.paris.lutece.plugins%3Aplugin-rest&metric=coverage)](https://dev.lutece.paris.fr/sonar/dashboard?id=fr.paris.lutece.plugins%3Aplugin-rest)

# Plugin REST

## Introduction
This plugin allows you to develop JAXRS REST services.
## Configuration

This plugin uses Jersey 2.

Singleton Root resources need the @component ( org.springframework.stereotype.Component ) annotation in addition to@path

Warning : This version 3.0.0 is not fully backwards compatible with oldest implementations.

 
* Jersey will not use the spring bean without @component annotation and will instantiate the bean itself (the scope can be controller through annotations:prototype, request, singleton).
* Spring Root resources with scope session or request are no longer supported

## Usage

Example of REST implementation :

```

@Path( SERVICE_PATH )
public class MyRest {

    @GET
    @Path( Constants.SEARCH_PATH )
    @Component
    @Produces( MediaType.APPLICATION_JSON )
    public Response getItemsList(  )
    {
    	// search...
    	
	return Response.status( Response.Status.NOT_FOUND )
                .entity( JsonUtil.buildJsonResponse( new ErrorJsonResponse( Response.Status.NOT_FOUND.name( ), Constants.ERROR_NOT_FOUND_VERSION ) ) )
                .build( );
    }
}
			    
```

The Rest classes should be declared in plugin context :

```

<bean id="my-app.restService"
   class="fr.paris.lutece.plugins.myapp.modules.rest.service.myappRest">
                
```


[Maven documentation and reports](https://dev.lutece.paris.fr/plugins/plugin-rest/)



 *generated by [xdoc2md](https://github.com/lutece-platform/tools-maven-xdoc2md-plugin) - do not edit directly.*