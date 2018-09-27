


// 객체 생성  --> 리펙토링 진행
// var template = {
module.exports = {
    html: function (title, list, body, control) {
        return `
        <!doctype html>
        <html>
        <head>
          <title>WEB - ${title}</title>
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
    },

    authorSelect:function(authors, author_id) {
        var tag = "";
        var selected = "";
        for(var i=0; i<authors.length; i++) {
            if(author_id === authors[i].id) {
                selected = " selected";
            } else {
                selected = "";
            }
            tag += `<option value="${authors[i].id}" ${selected}>${authors[i].name}</option>`;
        }

        return `
            <select name="author">
                ${tag}
            </select>
        `
    }
}


// module.exports = template;