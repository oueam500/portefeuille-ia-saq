<script setup>
import { computed, onMounted, ref } from "vue";
import { getDemandes } from "../services/api";
import KpiCard from "../components/portefeuille/KpiCard.vue";
import PortfolioFilters from "../components/portefeuille/PortfolioFilters.vue";
import DemandeTable from "../components/portefeuille/DemandeTable.vue";

const demandes = ref([]);
const chargement = ref(true);
const erreur = ref("");

const recherche = ref("");
const direction = ref("");
const statut = ref("");
const categorie = ref("");
const tri = ref("score");

onMounted(async () => {
  try {
    demandes.value = await getDemandes();
  } catch (e) {
    erreur.value = "Impossible de charger les demandes.";
    console.error(e);
  } finally {
    chargement.value = false;
  }
});

const demandesFiltrees = computed(() => {
  const texte = recherche.value.trim().toLowerCase();

  const resultat = demandes.value.filter((demande) => {
    const contenu = [
      demande.titre,
      demande.demandeur,
      demande.direction,
      demande.categorie,
      demande.priorite,
      demande.statut
    ]
      .filter(Boolean)
      .join(" ")
      .toLowerCase();

    return (
      (!texte || contenu.includes(texte)) &&
      (!direction.value || demande.direction === direction.value) &&
      (!statut.value || demande.statut === statut.value) &&
      (!categorie.value || demande.categorie === categorie.value)
    );
  });

  return [...resultat].sort((a, b) => {
    if (tri.value === "titre") {
      return a.titre.localeCompare(b.titre);
    }

    if (tri.value === "direction") {
      return a.direction.localeCompare(b.direction);
    }

    return b.scoreGlobal - a.scoreGlobal;
  });
});

const directions = computed(() =>
  [...new Set(demandes.value.map((d) => d.direction))]
    .filter(Boolean)
    .sort()
);

const statuts = computed(() =>
  [...new Set(demandes.value.map((d) => d.statut))]
    .filter(Boolean)
    .sort()
);

const categories = computed(() =>
  [...new Set(demandes.value.map((d) => d.categorie))]
    .filter(Boolean)
    .sort()
);

const scoreMedian = computed(() => {
  if (!demandes.value.length) return "—";

  const scores = demandes.value
    .map((d) => Number(d.scoreGlobal) || 0)
    .sort((a, b) => a - b);

  const milieu = Math.floor(scores.length / 2);

  if (scores.length % 2 === 0) {
    return ((scores[milieu - 1] + scores[milieu]) / 2).toFixed(1);
  }

  return scores[milieu].toFixed(1);
});

const prioritesElevees = computed(() =>
  demandes.value.filter(
    (d) => d.priorite === "Haute" || d.priorite === "Critique"
  ).length
);

const projetsStrategiques = computed(() =>
  demandes.value.filter((d) =>
    d.categorie?.toLowerCase().includes("stratégique")
  ).length
);
</script>

<template>
  <section>
    <div class="page-header">
      <h1>
        La vue
        <span>de portefeuille</span>
      </h1>

      <p>
        Les initiatives qualifiées et classées selon leur score global.
        Cette vue centralise les demandes IA et soutient leur priorisation.
      </p>
    </div>

    <div class="kpi-grid">
      <KpiCard
        :value="demandes.length"
        label="Demandes actives"
      />

      <KpiCard
        :value="scoreMedian"
        label="Score médian"
      />

      <KpiCard
        :value="prioritesElevees"
        label="Priorités élevées"
      />

      <KpiCard
        :value="projetsStrategiques"
        label="Projets stratégiques"
      />
    </div>

    <div class="portfolio-card">
      <PortfolioFilters
        v-model:recherche="recherche"
        v-model:direction="direction"
        v-model:statut="statut"
        v-model:categorie="categorie"
        v-model:tri="tri"
        :directions="directions"
        :statuts="statuts"
        :categories="categories"
      />

      <div v-if="chargement" class="message">
        Chargement du portefeuille...
      </div>

      <div v-else-if="erreur" class="message error">
        {{ erreur }}
      </div>

      <DemandeTable
        v-else
        :demandes="demandesFiltrees"
      />
    </div>

    <p class="footnote">
      Sélectionne une demande pour consulter ultérieurement sa fiche complète
      et la traçabilité de l'analyse.
    </p>
  </section>
</template>

<style scoped>
.page-header {
  margin-bottom: 20px;
}

.page-header h1 {
  margin: 0;
  font-size: 26px;
  letter-spacing: -0.02em;
}

.page-header h1 span {
  color: var(--bordeaux);
}

.page-header p {
  max-width: 820px;
  margin: 6px 0 0;
  color: var(--texte-secondaire);
  line-height: 1.5;
}

.kpi-grid {
  display: grid;
  grid-template-columns: repeat(4, minmax(180px, 1fr));
  gap: 14px;
  margin-bottom: 18px;
}

.portfolio-card {
  overflow: hidden;
  background: white;
  border: 1px solid var(--bordure);
  border-radius: 10px;
}

.message {
  padding: 40px;
  color: var(--texte-discret);
  text-align: center;
}

.message.error {
  color: var(--rouge);
}

.footnote {
  margin-top: 12px;
  color: var(--texte-discret);
  font-size: 12px;
}

@media (max-width: 1000px) {
  .kpi-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 600px) {
  .kpi-grid {
    grid-template-columns: 1fr;
  }
}
</style>