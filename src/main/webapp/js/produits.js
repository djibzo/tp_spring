$(document).ready(function () {
    loadProduits();
    function loadProduits() {
    $.get("/produits", function (produits) {
    $("#produitsTable").empty();
    produits.forEach(function (produit) {
    $("#produitsTable").append(`
                            <tr id="row-${produit.id}">
                                <td>${produit.reference}</td>
                                <td>${produit.designation}</td>
                                <td>${produit.prix} FCFA</td>
                                <td>${produit.quantite}</td>
                                <td>
                                    <button class="btn btn-warning btn-sm editBtn"
                                        data-id="${produit.id}"
                                        data-designation="${produit.designation}"
                                        data-reference="${produit.reference}"
                                        data-prix="${produit.prix}"
                                        data-quantite="${produit.quantite}">
                                        Modifier
                                    </button>
                                    <button class="btn btn-danger btn-sm deleteBtn" data-id="${produit.id}">Supprimer</button>
                                </td>
                            </tr>
                        `);
});
});
}

    $("#produitForm").submit(function (event) {
    event.preventDefault();
    var id = $("#id").val();
    var produit = {
    designation: $("#designation").val(),
    reference: $("#reference").val(),
    prix: $("#prix").val(),
    quantite: $("#quantite").val()
    };

    if (id) {
    // Modification
    $.ajax({
    url: `/produits/${id}`,
    type: "PUT",
    contentType: "application/json",
    data: JSON.stringify(produit),
    success: function () {
    loadProduits();
    resetForm();
}
});
} else {
    // Ajout
    $.ajax({
    url: "/produits",
    type: "POST",
    contentType: "application/json",
    data: JSON.stringify(produit),
    success: function () {
    loadProduits();
    resetForm();
}
});
}
});

    $(document).on("click", ".editBtn", function () {
    $("#id").val($(this).data("id"));
    $("#designation").val($(this).data("designation"));
    $("#reference").val($(this).data("reference"));
    $("#prix").val($(this).data("prix"));
    $("#quantite").val($(this).data("quantite"));
    $("#submitBtn").text("Modifier");
    $("#form-title").text("Modifier un Produit");
});

    $(document).on("click", ".deleteBtn", function () {
    var id = $(this).data("id");
    if (confirm("Voulez-vous vraiment supprimer ce produit ?")) {
    $.ajax({
    url: `/produits/${id}`,
    type: "DELETE",
    success: function () {
    loadProduits();
}
});
}
});
    function resetForm() {
    $("#id").val("");
    $("#designation").val("");
    $("#reference").val("");
    $("#prix").val("");
    $("#quantite").val("");
    $("#submitBtn").text("Ajouter");
    $("#form-title").text("Ajouter un Produit");
}
});