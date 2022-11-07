<template lang="">
    <div>
        <div class="header-wrapper">
            <div class="header-banner">
                <div class="container">
                    <a href="/">
                        <img class="logo" src="static/imgs/login/logoblack.png" />
                    </a>
                    
                    
                </div>
            </div>
        </div>
        <main>
            <div class="auth-form">
                <div class="auth-form-header"><h1>Sign into GGit</h1></div>
                <div class="auth-form-body">
                    <form>
                        <label class="body-label" for="login_field">email address</label>
                        <input type="text" name="login" id="login_field" class="form-control input-block"></input>

                        <div>
                            <label for="password">Password</label>
                            <a class="label-link" tabindex="0" href="/login">Forgot password?</a>
                            <input type="password" name="password" id="password" class="form-control input-block"></input>
                            <input type="submit" name="commit" value="Sign in" class="btn btn-primary btn-block"></input>
                        </div>
                    </form>
                </div>
            </div>
        </main>
    </div>
</template>
<script>
export default {
    data() {
        return {

        }
    },
    methods: {

    }
}
</script>
<style lang="sass">
    @import 'src/assets/sass/login/login.sass'
</style>