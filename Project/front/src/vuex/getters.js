export default {
  getUserId: state => state.userId,
  getUserEmail: state => state.email,
  getUserIdx: state => state.userIdx,
  getErrorState: state => state.errorState,
  getIsAuth: state => state.isAuth,
  getIsLogin: state => state.isLogin,
  getIsNick: state => state.isNick,
  loggedIn(state) {
    return !!state.user;
  }
};
