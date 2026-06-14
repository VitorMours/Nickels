import Account from "../../account/entities/account.entity";
import { Entity, Column, PrimaryColumn, CreateDateColumn, UpdateDateColumn, PrimaryGeneratedColumn, OneToMany } from "typeorm";

@Entity('users')
export class User {
  @PrimaryGeneratedColumn()
  id!: number;

  @Column()
  firstName!: string;

  @Column({ nullable: true })
  lastName?: string;

  @Column({ unique: true })
  email!: string;

  @Column()
  password!: string;

  @OneToMany(() => Account, (account: Account) => account.users)
  accounts?: Account[];

  @CreateDateColumn()
  createdAt!: Date;

  @UpdateDateColumn()
  updatedAt!: Date;
}
