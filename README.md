# Portefeuille IA SAQ

## Objectif

Application de gouvernance IA permettant :

- La centralisation des demandes IA
- La qualification des besoins
- La priorisation des initiatives
- La gestion d'un portefeuille IA
- Le support à la prise de décision

---

## Architecture actuelle

### Backend

Technologie :

- Java

Architecture :

```text
Main
↓
DemandeService
↓
DemoData
↓
API HTTP
```

API locale disponible :

```http
GET /demandes
```

---

### Frontend

Technologies :

- Vue 3
- Vite
- JavaScript

Communication :

```text
Vue
↓
Fetch
↓
http://localhost:8080/demandes
↓
API Java
```

---

## Structure du backend

```text
backend/

src/

├── Main.java

├── api/
│   └── DemandeApi.java

├── data/
│   └── DemoData.java

├── export/
│   └── DemandesJsonExporter.java

├── model/
│   ├── Demande.java
│   ├── Analyse.java
│   └── Score.java

└── service/
    └── DemandeService.java
```

---

## Structure du frontend

```text
front/

src/

├── App.vue

├── views/
│   ├── DashboardView.vue
│   ├── PortefeuilleView.vue
│   ├── NouvelleDemandeView.vue
│   └── DemandeDetailView.vue

├── components/
│
│   ├── layout/
│   │   ├── AppHeader.vue
│   │   ├── AppLayout.vue
│   │   └── AppSidebar.vue
│   │
│   ├── portefeuille/
│   │   ├── DemandeTable.vue
│   │   ├── KpiCard.vue
│   │   ├── PortfolioFilters.vue
│   │   └── StatusBadge.vue
│   │
│   ├── dashboard/
│   └── demande/
│
├── services/
│   └── api.js
│
└── router/
```

---

## Données actuelles

Les données proviennent de :

```text
DemoData.java
```

Aucune base de données n'est utilisée pour le moment.

Les demandes sont exportées dans :

```text
demandes.json
```

et exposées via :

```http
GET /demandes
```

---

## Modèle métier

### Demande

```text
id
titre
demandeur
direction
statut
analyse
```

### Analyse

```text
resume
recommandation
categorie
priorite
scoreGlobal
score
```

### Score

```text
valeurAffaires
productivite
coutsEvites
portee
faisabilite
```

---

## État du projet

### Fonctionnel

Backend Java

API HTTP

Export JSON

Front Vue connecté au backend

Affichage des demandes

Vue portefeuille de base

---

## Travaux frontend prioritaires

- Reproduire la maquette HTML de référence
- Navigation
- KPI
- Tableau portefeuille
- Filtres
- Badges et statuts
- Détail d'une demande

---

## Travaux backend futurs

- Remplacer DemoData par une source persistante
- CRUD complet
- Intégration de l'Agent IA
- Intégration ServiceNow

---

## Important

Le backend actuel est un backend de démonstration destiné à alimenter le développement du frontend.

Les données sont temporaires et proviennent de DemoData.

L'intégration de l'Agent de Qualification IA sera réalisée dans une phase ultérieure.