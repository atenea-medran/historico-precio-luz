<#macro header>
    <!DOCTYPE html>
    <html lang="es">
    <head>
        <title>Histórico precio luz</title>
        <link rel="icon" href="static/headerlogo.ico" type="image/x-icon">
        <style>
            .header {
                display: flex;
                align-items: center;
            }
            .header img {
                float: left;
                margin-top: auto;
                margin-bottom: auto;
                margin-right: 20px;
                margin-left: 80px;
            }

            .header h2 {
                text-align: left;

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

            body {
                font-family:sans-serif
            }

        </style>
    </head>
    <body>
        <div class="header clearfix">
            <img src="/static/bodylogo.svg">
            <h2>Precio del kWh en céntimos</h2>
        </div>
        <#nested>
    </body>
    </html>
</#macro>