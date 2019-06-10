# Jira-Scrum-Agent

Donde conseguir la info necesaria para consultar los puntos más adelante: 

Getting Started  ->  https://developer.atlassian.com/cloud/jira/platform/getting-started/

Qué se necesita: 

- IntelliJ con los plugins de maven y nodejs y spring (aunque se puede tener maven por separado)
Si tenemos IntelliJ con los plugins directamente importamos el proyecto.
Si no tenemos IntelliJ tambien se puede hacer desde eclipse (averiguar cómo)

- nodejs

- git

- ngrok (Mirar: Step 3. Set up your local development environment en el getting started)

Para cargar el proyecto:

    1° Paso: descargamos el repositorio y nos crea un repositorio local
    Desde el cmd ejecutar:

    git clone https://github.com/jmbidev/Jira-Scrum-Agent

    2° Paso: importar el proyecto desde IntelliJ (Seleccionando maven)

    Este paso suele tardar bastante porque descarga todas las librerias necesarias
    
Para compilar el proyecto:
    Esto lo podemos hacer desde el IntelliJ sin problemas
    
Antes de poder incluir la app a Jira: (se puede seguir desde el getting-started de arriba)

    1° Paso: el administrador del proyecto de Jira se tiene que crear una cuenta en Atlassian.
       (mirar Step 1. Get an Atlassian Cloud instance en el getting started)
    2° Paso: hay que habilitar el modo desarrollador en las configuraciones.
       (mirar Step 2. Enable development mode)

Para añadir la app a Jira:  
    
    1° Paso: ejecutar en cmd
       - ngrok http localhost:3000 
       Esto nos permite vincular esa direccion local a una direccion pública y ahí mismo nos va a aparecer 
       direcciones mapeadas de ngrok. (Mirar: Step 2: Make the app files available to the internet en el
       getting started).
       
    2° Paso: en la pestaña cmd que ejecutamos ngrok copiar la direccion https (aparece tambien la http pero 
       no la necesitamos).
       Ejemplo de dirección que aparece: https://4df531ad.ngrok.io 
    
    3° Paso: en el proyecto de IntelliJ modificamos el archivo que se llama atlassian-connect.json
       Reemplazamos la direccion que está en "baseUrl" por la que copiamos de ngrok
       
    4° Paso: ejecutamos la aplicación desde IntelliJ
       Para chequear que funcione correctamente podemos abrir localhost:3000 y tiene que aparecer lo mismo que en
       https://4df531ad.ngrok.io (o la dir que les tocó)
       
    5° Paso: entramos en la app de Jira y vamos a Configuracion->Aplicaciones->ManageApps->Subir aplicación
       En el campo que nos aparece copiamos la dir: https://4df531ad.ngrok.io/atlassian-connect.json
       Reemplazar https://4df531ad.ngrok.io por la dir que les tocó a ustedes y apretar upload.
       (Mirar: Step 3: Install and test your app en el getting started.)
      
    6° Si todo salio bien les va a decir que está Ok y si apretan el logo de Jira (arriba a la izquierda) los lleva 
       al inicio y deberían poder ver un enlace a JiraScrumAgent en la barra. Si entran deberian poder ver el mensaje 
       de bienvenida de la app.
    


