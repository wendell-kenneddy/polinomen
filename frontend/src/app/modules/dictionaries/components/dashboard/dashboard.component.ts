import { ChangeDetectionStrategy, Component, computed, inject } from '@angular/core';
import { DictionaryCardComponent } from '../dictionary-card/dictionary-card.component';
import { DictionariesService } from '../../services/dictionaries.service';
import { Dictionary } from '../../model/dictionary.model';

@Component({
  selector: 'app-dashboard',
  imports: [DictionaryCardComponent],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class DashboardComponent {
  private dictionariesService = inject(DictionariesService);

  protected dictionaries: Dictionary[] = this.dictionariesService.getDictionaries();
}
