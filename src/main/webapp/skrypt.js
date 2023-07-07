const miesiace = ['stycznia', 'lutego', 'marca', 'kwietnia', 'maja', 'czerwca', 'lipca', 'sierpnia',  'września', 'października', 'listopada', 'grudnia' ];

function funkcje() {
    let news1 = document.getElementById("news1");
    let news2 = document.getElementById("news2");
    news1.innerHTML = powitanie()+"<br/>"+data()+"<br/>";
    news2.innerHTML = dniDoUrodzin();
}

function powitanie() {
    let dzisiaj = new Date();
    let godzina = dzisiaj.getHours();
    if( (godzina<18) && (godzina>6) ) {
        return 'Dzień dobry,';
    } else {
        return 'Dobry wieczór,';
    }
}

function data() {
    let dzisiaj = new Date();
    let dzien =  dzisiaj.getDate();
    let miesiac = miesiace[dzisiaj.getMonth()];
    let rok = dzisiaj.getFullYear();

    return 'dzisiaj jest '+ dzien + ' ' +  miesiac + ' ' + ' '  + rok + ' r.';
}

function dniDoUrodzin(){
    let dzisiaj = new Date();
    let urodzinyDzien = 29;
    let urodzinyMiesiac = 9; //Miesiace indeksowane są od 0. tzn 0 - styczeń 9 - pażdziernik etc.
    let urodzinyRok = 0;

    if(dzisiaj.getMonth() > urodzinyMiesiac || (dzisiaj.getDate() > urodzinyDzien && dzisiaj.getMonth() == urodzinyMiesiac )){
        urodzinyRok = dzisiaj.getFullYear() + 1;
    }
    else{
        urodzinyRok = dzisiaj.getFullYear();
    }

    let dataUrodzin = new Date(urodzinyRok,urodzinyMiesiac,urodzinyDzien);
    return 'Dni do urodzin autora: ' + Math.floor((dataUrodzin - dzisiaj)/(1000*60*60*24) + 1);
}