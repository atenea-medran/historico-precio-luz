<#-- @ftlvariable name="days" type="kotlin.collections.List<com.ateneamedran.models.Day>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <style>
        .center {
            border-collapse: collapse;
            margin-left: auto;
            margin-right: auto;
            padding-top: 50px;
            padding-bottom: 50px;
            padding-right: 50px;
            padding-left: 50px;
        }
        td, th {
            border: 3px solid #dddddd;
            text-align: center;
            padding-left: 5px;
            padding-right: 5px;
            padding-top: 2px;
            padding-bottom: 2px;
            font-size: 16px;
        }
    </style>
        <body>
        <table class="center">
            <tr>
                <th>Fecha</th>
                <th>00-01</th>
                <th>01-02</th>
                <th>02-03</th>
                <th>03-04</th>
                <th>04-05</th>
                <th>05-06</th>
                <th>06-07</th>
                <th>07-08</th>
                <th>08-09</th>
                <th>09-10</th>
                <th>10-11</th>
                <th>11-12</th>
                <th>12-13</th>
                <th>13-14</th>
                <th>14-15</th>
                <th>15-16</th>
                <th>16-17</th>
                <th>17-18</th>
                <th>18-19</th>
                <th>19-20</th>
                <th>20-21</th>
                <th>21-22</th>
                <th>22-23</th>
                <th>23-00</th>
            </tr>
        <#list days as day>
            <tr>
                <td>${day.fecha}</td>
                <td>${day.price01}</td>
                <td>${day.price12}</td>
                <td>${day.price23}</td>
                <td>${day.price34}</td>
                <td>${day.price45}</td>
                <td>${day.price56}</td>
                <td>${day.price67}</td>
                <td>${day.price78}</td>
                <td>${day.price89}</td>
                <td>${day.price910}</td>
                <td>${day.price1011}</td>
                <td>${day.price1112}</td>
                <td>${day.price1213}</td>
                <td>${day.price1314}</td>
                <td>${day.price1415}</td>
                <td>${day.price1516}</td>
                <td>${day.price1617}</td>
                <td>${day.price1718}</td>
                <td>${day.price1819}</td>
                <td>${day.price1920}</td>
                <td>${day.price2021}</td>
                <td>${day.price2122}</td>
                <td>${day.price2223}</td>
                <td>${day.price2300}</td>
            </tr>
        </#list>

        </table>
        </body>
    <hr>
</@layout.header>