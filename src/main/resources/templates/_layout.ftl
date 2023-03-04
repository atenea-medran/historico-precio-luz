<#macro header>
    <!DOCTYPE html>
    <html lang="es">
    <head>
        <title>Histórico precio luz</title>
        <style>
            .header {
                padding-bottom: 50px;
            }
            .header img {
                float: left;
                width: 200px;
                height: 125px;
                background: #555;
            }

            .header h1 {
                position: relative;
                top: 20px;
                left: 10px;
            }

            .clearfix:before,
            .clearfix:after {
                content: "";
                display: table;
            }

            .clearfix:after {
                clear: both;
            }

            .clearfix {
                *zoom: 1;
            }

        </style>
    <body style="font-family: sans-serif">
        <div class="header clearfix">
            <img src="/static/kwh_logo.webp">
            <h1>Histórico precio luz</h1>
            <h2>Precio del kWh en céntimos</h2>
        </div>
        <#nested>
        <a href="/" float="center">Back to the main page</a>
    </body>
    </html>
</#macro>