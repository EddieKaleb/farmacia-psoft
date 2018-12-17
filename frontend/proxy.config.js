const proxy = [
    {
      context: '/api',
      target: 'https://cccpharma-backend.herokuapp.com/',
      pathRewrite: {'^/api' : ''}
    }
  ];
  
  module.exports = proxy;