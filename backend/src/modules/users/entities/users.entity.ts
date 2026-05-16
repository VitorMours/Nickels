import { Entity, Column, PrimaryGeneratedColumn, CreateDateColumn, UpdateDateColumn } from "typeorm";


@Entity('users')
export class User {
  @PrimaryGeneratedColumn('uuid')
  id!: number;

  @Column({ unique: true })
  email!: string;

  @Column({ nullable: false })
  firstName!: string;


  @Column({ nullable: true })
  lastName?: string;

  @Column({ default: true })
  isActive!: boolean;

  @CreateDateColumn({ 
    type: 'timestamp', 
    default: () => 'CURRENT_TIMESTAMP(6)' 
  })
  createdAt!: Date;

  @UpdateDateColumn({ 
    type: 'timestamp', 
    default: () => 'CURRENT_TIMESTAMP(6)', 
    onUpdate: 'CURRENT_TIMESTAMP(6)' 
  })
  updatedAt!: Date;

}