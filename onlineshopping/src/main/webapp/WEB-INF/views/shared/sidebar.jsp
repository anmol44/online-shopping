
<h1 class="my-4">ANMOL SHOP</h1>
<p class = "lead"></p>
<div class="list-group">

	<c:forEach items="${categories}" var="category">

		<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item" id = "a_${category.name}">${category.name}</a>
	</c:forEach>



</div>

