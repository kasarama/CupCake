
<c:forEach var="order" items="${requestScope.orders}">
    <div class="container float-lg-right">
        <table class="table table-sm">
            <tr>
                <th>Ordre nr: ${order.id}</th>
                <th>Bund</th>
                <th>Topping</th>
                <th>Antal</th>
            </tr>

            <c:forEach var="ciastko" items="${order.products}">
                <tr>
                    <th></th>
                    <th>${ciastko.key.bottom}</th>
                    <th>${ciastko.key.topping}</th>
                    <th>${ciastko.value}</th>
                </tr>
            </c:forEach>


            <tr>
                <th></th>
                <th>Sum</th>
                <th>${order.sum}</th>
                <th>kr</th>
            </tr>


        </table>
    </div>
</c:forEach>
