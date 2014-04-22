08UrlAccessLog
--------------

Web filters are useful for preprocessing requests and invoking certain functionality when a given URL is visited.

any filter that contains the same URL pattern will be invoked prior to the servlet. 

This can be helpful in many situations, perhaps the most useful for performing logging,
authentication, or other services that occur in the background without user interaction.

How
---

Filters must implement the javax.servlet.Filter interface

Methods contained within this interface include init, destroy, and doFilter. 

The init and destroy methods are invoked by the container. 

The doFilter method is used to implement tasks for the filter class.

Configuration
-------------

1)the @WebFilter annotation takes care of the configuration for you

or

2) Web.xml
----------

If you want to chain filters or if more than one filter exists for a given URL pattern, they will be invoked in the
order in which they are configured in the web.xml deployment descriptor.

<filter>
<filter-name>LoggingFilter</filter-name>
<filter-class>LoggingFilter</filter-class>
</filter>
<filter-mapping>
<filter-name>LogingFilter</filter-name>
<url-pattern>/*</url-pattern>
</filter-mapping>

Web.xml
-------

If you want to chain filters or if more than one filter exists for a given URL pattern, they will be invoked in the
order in which they are configured in the web.xml deployment descriptor.

