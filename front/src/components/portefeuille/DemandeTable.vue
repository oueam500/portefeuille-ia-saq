<script setup>
import StatusBadge from "./StatusBadge.vue";

defineProps({
  demandes: {
    type: Array,
    default: () => []
  }
});
</script>

<template>
  <div class="table-wrapper">
    <table>
      <thead>
        <tr>
          <th class="left project-column">Demande</th>
          <th>Direction</th>
          <th>Score global</th>
          <th>Catégorie</th>
          <th>Priorité</th>
          <th>Statut</th>
        </tr>
      </thead>

      <tbody>
        <tr
          v-for="(demande, index) in demandes"
          :key="demande.id"
        >
          <td class="left">
            <div class="project">
              <span class="rank">
                {{ String(index + 1).padStart(2, "0") }}
              </span>

              <div>
                <button class="project-title">
                  {{ demande.titre }}
                </button>

                <div class="meta">
                  <span class="tag">
                    {{ demande.demandeur }}
                  </span>

                  <span class="identifier">
                    IA-{{ String(demande.id).padStart(4, "0") }}
                  </span>
                </div>
              </div>
            </div>
          </td>

          <td>{{ demande.direction }}</td>

          <td>
            <strong class="score">
              {{ Number(demande.scoreGlobal).toFixed(1) }}
            </strong>
          </td>

          <td>
            <span class="category">
              {{ demande.categorie }}
            </span>
          </td>

          <td>
            <StatusBadge
              :value="demande.priorite"
              type="priorite"
            />
          </td>

          <td>
            <StatusBadge
              :value="demande.statut"
              type="statut"
            />
          </td>
        </tr>

        <tr v-if="demandes.length === 0">
          <td colspan="6" class="empty">
            Aucune demande ne correspond aux filtres.
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped>
.table-wrapper {
  overflow-x: auto;
}

table {
  width: 100%;
  border-collapse: collapse;
}

th {
  padding: 12px 14px;
  color: var(--texte-discret);
  background: #fafafc;
  border-bottom: 1px solid var(--bordure);
  font-family: Consolas, monospace;
  font-size: 10px;
  font-weight: 600;
  letter-spacing: 0.07em;
  text-align: center;
  text-transform: uppercase;
  white-space: nowrap;
}

th.left,
td.left {
  text-align: left;
}

.project-column {
  width: 38%;
}

td {
  padding: 13px 14px;
  border-bottom: 1px solid #f0f0f4;
  text-align: center;
  vertical-align: middle;
}

tbody tr:hover {
  background: #fcfbfc;
}

.project {
  display: flex;
  align-items: flex-start;
  gap: 10px;
}

.rank {
  padding-top: 2px;
  color: var(--texte-discret);
  font-family: Consolas, monospace;
  font-size: 12px;
}

.project-title {
  padding: 0;
  color: var(--texte);
  background: transparent;
  border: 0;
  cursor: pointer;
  font-weight: 600;
  text-align: left;
}

.project-title:hover {
  color: var(--bordeaux);
  text-decoration: underline;
}

.meta {
  display: flex;
  align-items: center;
  gap: 6px;
  margin-top: 6px;
  flex-wrap: wrap;
}

.tag {
  padding: 2px 8px;
  color: var(--bleu);
  background: #eef1f6;
  border-radius: 20px;
  font-size: 11px;
  font-weight: 600;
}

.identifier {
  padding: 2px 8px;
  color: var(--texte-discret);
  background: #f4f4f7;
  border-radius: 20px;
  font-family: Consolas, monospace;
  font-size: 10px;
}

.score {
  font-size: 18px;
  letter-spacing: -0.02em;
}

.category {
  display: inline-block;
  max-width: 180px;
  font-size: 12px;
  font-weight: 600;
}

.empty {
  padding: 40px;
  color: var(--texte-discret);
}
</style>