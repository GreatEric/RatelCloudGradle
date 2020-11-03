export const state = () => ({
  routing:{
    from: {},
    current: {}
  }
})

export const mutations = {
  route(state, info) {
    state.routing.from = info.from;
    state.routing.current = info.current;
  }
}
