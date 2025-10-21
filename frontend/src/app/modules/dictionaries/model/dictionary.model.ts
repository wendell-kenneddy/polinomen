import { Tag } from './tag.model';

export interface Dictionary {
  title: string;
  description: string;
  tags: Tag[];
  wordCount: number;
}
