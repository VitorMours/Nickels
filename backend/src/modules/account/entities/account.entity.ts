import { User } from "../../users/entities/users.entity";
import { Entity, Column, PrimaryGeneratedColumn, CreateDateColumn, UpdateDateColumn, ManyToOne, JoinColumn } from "typeorm";

@Entity('accounts')
export default class Account {
  @PrimaryGeneratedColumn()
  id!: number;

  @Column()
  accountName!: string;
  
  @ManyToOne(() => User, (user) => user.accounts, { onDelete: 'CASCADE' })
  @JoinColumn({ name: 'users_id' })
  users!: User[]

  @CreateDateColumn()
  createdAt!: Date;
  
  @UpdateDateColumn()
  updatedAt!: Date;
}
