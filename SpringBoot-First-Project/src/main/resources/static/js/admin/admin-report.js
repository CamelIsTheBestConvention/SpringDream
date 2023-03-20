function searchBoard(num, param) {
    let form = document.createElement('form');

    let objs;

    objs = document.createElement('input');

    objs.setAttribute('type', 'hidden');

    objs.setAttribute('name', param);      // 받을 네이밍

    objs.setAttribute('value', num);       // 넘길 파라메터

    form.appendChild(objs);

    form.setAttribute('method', 'post');

    form.setAttribute('action', "/admin/boards/search.number");      // URL

    document.body.appendChild(form);

    form.submit();
}

function searchMember(num, param) {
    let form = document.createElement('form');

    let objs;

    objs = document.createElement('input');

    objs.setAttribute('type', 'hidden');

    objs.setAttribute('name', param);      // 받을 네이밍

    objs.setAttribute('value', num);       // 넘길 파라메터

    form.appendChild(objs);

    form.setAttribute('method', 'post');

    form.setAttribute('action', "/admin/userlist");      // URL

    document.body.appendChild(form);

    form.submit();
}