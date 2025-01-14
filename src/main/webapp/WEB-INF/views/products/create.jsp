<h2>Créer un produit</h1>
    <form action="${pageContext.request.contextPath}/products/create" method="post" enctype="multipart/form-data">
        <label>Nom :</label>
        <input type="text" name="name" required /><br />
        <label>Description :</label>
        <textarea name="description" required></textarea><br />
        <label>Prix :</label>
        <input type="number" name="price" step="0.01" required /><br />
        <label>Stock :</label>
        <input type="number" name="stock" required /><br />
        <label>Image :</label>
        <input type="file" name="imageFile" /><br />
        <button type="submit">Créer</button>
    </form>