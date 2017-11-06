<div class="container">

	<div class="row">

		<!-- would be to display sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
		<!--to display the actual products  -->
		<div class="col-md-9">
			<!-- test the page breadcrumb bootstrap -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts == true}">
						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">


							<li><a href="${contextRoot}/home">home</a></li>
							<li class="active">All Products</li>

						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts == true}">

						<script>
							window.categoryId = '${category.id}';
						</script>

						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">home</a></li>


							<li class="active">Category</li>
							<li class="active">${category.name}</li>


						</ol>
					</c:if>

				</div>

			</div>

			<div class="row">
				<div class="col-xs-12">
					<table id="productListTable"
						class="table table-striped table-bordered">

						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>brand</th>
								<th>Price</th>
								<th>qty. available</th>
								<th>views</th>
								<th></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th></th>
								<th>Name</th>
								<th>brand</th>
								<th>Price</th>
								<th>qty. available</th>
								<th>views</th>
								<th></th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>


		</div>



	</div>


</div>