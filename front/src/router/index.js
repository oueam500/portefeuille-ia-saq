export const routes = [
  { path: '/', name: 'dashboard' },
  { path: '/portefeuille', name: 'portefeuille' },
  { path: '/nouvelle-demande', name: 'nouvelle-demande' },
  { path: '/demandes/:id', name: 'demande-detail' },
]

export function resolveRoute(path = window.location.pathname) {
  return routes.find((route) => {
    if (route.path.includes(':id')) {
      return path.startsWith(route.path.split('/:')[0])
    }
    return route.path === path
  }) || routes[0]
}
