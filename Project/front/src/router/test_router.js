


export default[

    {
        path: '/test',
        name: 'test',
        component: () => import('@/components/test/test')
    }
    ,{
        path: '/test1',
        name: 'test1',
        component: () => import('@/components/test/test1')
    }
    ,{
        path: '/test2',
        name: 'test2',
        component: () => import('@/components/test/test2')
    }
    ,{
      path: '/download/ggitsource',
      name: 'ggitsource',
      component: () => import('@/components/test/testfiledown')
  },{
      path: '/download',
      name: 'ggitsource',
      component: () => import('@/components/main/download')
  }
    ,{
      path: '/testSock',
      name: 'testSock',
      component: () => import('@/components/test/testSock')
  }

 


]

