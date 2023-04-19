const validarValores = () => {
  let valor1 = Number(document.querySelector(".valor1").value);
  let valor2 = Number(document.querySelector(".valor2").value);

  console.log(valor1, valor2);

  if (valor1 < 0 || valor1 > 10) {
    window.alert("Valor 1 deve estar entre 0 e 10!");
    document.querySelector(".valor1").focus();
    return false;
  }

  if (valor2 < 0 || valor2 > 10) {
    window.alert("Valor 2 deve estar entre 0 e 10!");
    document.querySelector(".valor2").focus();
    return false;
  }

  window.alert("Valores corretos!!!");
  return true;
};

const ordenarValores = () => {
  if (validarValores()) {
    let valor1 = parseInt(document.querySelector(".valor1").value);
    let valor2 = parseInt(document.querySelector(".valor2").value);

    if (valor1 > valor2) {
      window.alert("Maior valor: " + valor1 + "\nMenor valor: " + valor2);
    } else if (valor2 > valor1) {
      window.alert("Maior valor: " + valor2 + "\nMenor valor: " + valor1);
    } else {
      window.alert("Os Valores são iguais!");
    }
  }
};

const btnValidar = document.querySelector(".validar");
btnValidar.addEventListener("click", validarValores);

const btnOrdenar = document.querySelector(".ordenar");
btnOrdenar.addEventListener("click", ordenarValores);
