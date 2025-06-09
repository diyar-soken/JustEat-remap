import { Component, OnInit } from '@angular/core';
import { AlimentoService } from '../../services/alimento.service';
import { Alimento } from '../../models/alimento.model';
import {FormsModule} from "@angular/forms";
import {CurrencyPipe} from "@angular/common";

@Component({
  selector: 'app-alimenti',
  templateUrl: './alimenti.component.html',
  standalone: true,
  imports: [
    FormsModule,
    CurrencyPipe
  ],
  styleUrls: ['./alimenti.component.css']
})
export class AlimentiComponent implements OnInit {
  alimenti: Alimento[] = [];
  alimentoSelezionato: Alimento | null = null;
  modo: 'lista' | 'nuovo' | 'modifica' = 'lista';

  constructor(private alimentiService: AlimentoService) {}

  ngOnInit() {
    this.loadAlimenti();
  }

  loadAlimenti() {
    this.alimentiService.getAll().subscribe(data => {
      this.alimenti = data;
    });
  }

  nuova() {
    this.alimentoSelezionato = { id: 0, nome: '', costo: 0, ingredienti: '' };
    this.modo = 'nuovo';
  }

  modifica(alimento: Alimento) {
    this.alimentoSelezionato = { ...alimento };
    this.modo = 'modifica';
  }

  elimina(id: number) {
    this.alimentiService.delete(id).subscribe(() => {
      this.loadAlimenti();
    });
  }

  salva() {
    if (this.alimentoSelezionato) {
      if (this.alimentoSelezionato.id === 0) {
        this.alimentiService.create(this.alimentoSelezionato).subscribe(() => {
          this.loadAlimenti();
          this.modo = 'lista';
        });
      } else {
        this.alimentiService.update(this.alimentoSelezionato.id, this.alimentoSelezionato).subscribe(() => {
          this.loadAlimenti();
          this.modo = 'lista';
        });
      }
    }
  }

  annulla() {
    this.modo = 'lista';
  }
}
