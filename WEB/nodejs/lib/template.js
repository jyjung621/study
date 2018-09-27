


// 객체 생성  --> 리펙토링 진행
// var template = {
module.exports = {
    html: function (title, list, body, control) {
        return `
        <!doctype html>
        <html>
        <head>
          <title>WEB1 - ${title}</title>
          <meta charset="utf-8">
        </head>
        <body>
          <h1><a href="/">WEB</a></h1>  
          ${list}
          ${control}
          ${body}
        </body>
        </html>
        `;
    },

    list: function (topics) {
        var list = '<ul>';
        for (var i = 0; i < topics.length; i++) {
            list += `<li><a href='/?id=${topics[i].id}'>${topics[i].title}</a></li>`;
        }
        list += '</ul>';

        return list;
    }
}


// module.exports = template;