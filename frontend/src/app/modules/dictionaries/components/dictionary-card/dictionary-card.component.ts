import { ChangeDetectionStrategy, Component, input } from '@angular/core';
import { Dictionary } from '../../model/dictionary.model';

@Component({
  selector: 'dictionary-card',
  imports: [],
  templateUrl: './dictionary-card.component.html',
  styleUrl: './dictionary-card.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class DictionaryCardComponent {
  dictionary = input.required<Dictionary>();
}
