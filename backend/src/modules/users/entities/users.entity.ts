import { Entity, Column, PrimaryColumn, CreateDateColumn, UpdateDateColumn } from "typeorm";

@Entity('users')
export class User {
  @PrimaryColumn()
  id!: number;

  @Column()
  firstName!: string;

  @Column({ nullable: true })
  lastName?: string;

  @Column({ unique: true })
  email!: string;

  @Column()
  password!: string;

  @CreateDateColumn()
  createdAt!: Date;

  @UpdateDateColumn()
  updatedAt!: Date;
}