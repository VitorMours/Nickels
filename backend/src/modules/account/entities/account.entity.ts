import { Entity, Column, PrimaryGeneratedColumn, CreateDateColumn, UpdateDateColumn } from "typeorm";

@Entity('accounts')
export class Account{
  @PrimaryGeneratedColumn()
  id!: number;
}