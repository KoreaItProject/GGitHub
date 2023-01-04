export default {
  getUserId: state => state.userId,
  getUserNick: state => state.nick,
  getUserEmail: state => state.email,
  getUserIdx: state => state.idx,
  getErrorState: state => state.errorState,
  getIsAuth: state => state.isAuth,
  getIsLogin: state => state.isLogin,
  getIsNick: state => state.isNick,
  loggedIn(state) {
    return !!state.user;
  }
};
