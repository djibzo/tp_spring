<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Produits</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row">
        <!-- Formulaire d'ajout et modification -->
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
<script src="../../js/produits.js"></script>
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
