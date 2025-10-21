import { Injectable } from '@angular/core';
import { Dictionary } from '../model/dictionary.model';

@Injectable({
  providedIn: 'root',
})
export class DictionariesService {
  private readonly mockDictionaries: Dictionary[] = [
    {
      title: 'Harry Potter',
      description: 'Termos de Harry Potter.',
      tags: [{ name: 'Ficção' }],
      wordCount: 25,
    },
    {
      title: 'Harry Potter',
      description: 'Termos de Harry Potter.',
      tags: [{ name: 'Ficção' }],
      wordCount: 25,
    },
    {
      title: 'Harry Potter',
      description: 'Termos de Harry Potter.',
      tags: [{ name: 'Ficção' }],
      wordCount: 25,
    },
    {
      title: 'Harry Potter',
      description: 'Termos de Harry Potter.',
      tags: [{ name: 'Ficção' }],
      wordCount: 25,
    },
    {
      title: 'Harry Potter',
      description: 'Termos de Harry Potter.',
      tags: [{ name: 'Ficção' }],
      wordCount: 25,
    },
    {
      title: 'Harry Potter',
      description: 'Termos de Harry Potter.',
      tags: [{ name: 'Ficção' }],
      wordCount: 25,
    },
    {
      title: 'Harry Potter',
      description: 'Termos de Harry Potter.',
      tags: [{ name: 'Ficção' }],
      wordCount: 25,
    },
    {
      title: 'Harry Potter',
      description: 'Termos de Harry Potter.',
      tags: [{ name: 'Ficção' }],
      wordCount: 25,
    },
    {
      title: 'Harry Potter',
      description: 'Termos de Harry Potter.',
      tags: [{ name: 'Ficção' }],
      wordCount: 25,
    },
    {
      title: 'Harry Potter',
      description: 'Termos de Harry Potter.',
      tags: [{ name: 'Ficção' }],
      wordCount: 25,
    },
  ];

  public getDictionaries(): Dictionary[] {
    return this.mockDictionaries;
  }
}
