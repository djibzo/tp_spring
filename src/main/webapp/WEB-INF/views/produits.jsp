<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Produits</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row">
        <!-- Formulaire d'ajout/modification -->
        <div class="col-md-4">
            <div class="card shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h5 id="form-title">Ajouter un Produit</h5>
                </div>
                <div class="card-body">
                    <form id="produitForm">
                        <input type="hidden" id="id" name="id">
                        <div class="mb-3">
                            <label class="form-label">Reference :</label>
                            <input type="text" id="reference" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Designation :</label>
                            <input type="text" id="designation" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Prix :</label>
                            <input type="number" id="prix" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Quantité :</label>
                            <input type="number" id="quantite" class="form-control" required>
                        </div>
                        <button type="submit" class="btn btn-primary w-100" id="submitBtn">Ajouter</button>
                    </form>
                </div>
            </div>
        </div>

        <!-- Liste des produits -->
        <div class="col-md-8">
            <div class="card shadow-sm">
                <div class="card-header bg-success text-white">
                    <h5>Liste des Produits</h5>
                </div>
                <div class="card-body">
                    <table class="table table-striped">
                        <thead class="table-dark">
                        <tr>
                            <th>Reference</th>
                            <th>Designation</th>
                            <th>Prix</th>
                            <th>Quantité</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody id="produitsTable">
                        <!-- Les produits seront ajoutés ici dynamiquement -->
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<script>
    $(document).ready(function () {
        loadProduits();

        function loadProduits() {
            $.get("/produits", function (produits) {
                console.log(produits);
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
                                        data-nom="${produit.nom}"
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
</script>

</body>
</html>
