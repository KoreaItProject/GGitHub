import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },{
      path: '/a',
      name: 'a',
      component: HelloWorld
    }
    ,{
        path: '/test',
        name: 'test',
        component: () => import('@/views/test/test')
    }

  ]
})
