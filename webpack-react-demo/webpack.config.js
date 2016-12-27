var path = require('path');
//�ڿ���������ʹ��ѹ���ļ�
//1.ÿ�� "react" �ڴ����б����룬����ʹ��ѹ����� React JS �ļ��������ǵ� node_modules ���ҡ�
//2.ÿ�� Webpack ����ȥ�����Ǹ�ѹ������ļ���������ֹ������Ϊ�ⲻ��Ҫ��
var node_modules = path.resolve(__dirname,'node_modules');
var pathToReact = path.resolve(node_modules,'react/dist/react.min.js'); //Ϊ�˲��� Webpack ȥ���� React JS ��������������������ڿ�������д������Ϊ
var config = {
  entry: [
    'webpack/hot/dev-server',
    'webpack-dev-server/client?http://localhost:8080', //�������������Զ�ˢ��
    path.resolve(__dirname, 'app/main.js')
  ],
  resolve: {
    alias: {
      'react': pathToReact
    }
  },
  output: {
    path: path.resolve(__dirname, 'build'),
    filename: 'bundle.js'
  },
  module: {
    loaders: [{
      test: /\.js$/,
      loaders: ['react-hot', 'babel']
      },{
      test: /\.jsx?$/, // ��������ƥ���ļ�·���������˼��ƥ�� js ���� jsx
      loader: 'babel', // ����ģ�� "babel" �� "babel-loader" ����д
      query: {
        presets: ['react']
      }
    }, {
      test: /\.css$/, // Only .css files
      loader: 'style!css' // Run both loaders
    }],
    noParse: [pathToReact]
  }
};

module.exports = config;
