import { Negociacao } from "../models/negociacao.js";

export class NegociacaoController {
    private inputData: HTMLInputElement;
    private inputQuantidade: HTMLInputElement;
    private inputValor: HTMLInputElement;

    constructor() {
        this.inputData = document.querySelector('#data')
        this.inputQuantidade = document.querySelector('#quantidade')
        this.inputValor = document.querySelector('#valor')
    }

    adiciona(): void{
        const negociacao = this.criaNegociacao();
        this.limpaCampos();

    }

    criaNegociacao(): Negociacao{
        const regex = /-/g
        const data = new Date(this.inputData.value.replace(regex, ','));
        const quantidade = parseInt(this.inputQuantidade.value);
        const valor = parseFloat(this.inputValor.value);
        return new Negociacao(data, quantidade, valor);
    }

    limpaCampos(): void{
        this.inputData.value = '';
        this.inputQuantidade.value = '0';
        this.inputValor.value = '0.0';
        this.inputData.focus();
    }
}